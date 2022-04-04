package com.example.tmp.monopro.controller;


import com.example.tmp.monopro.entity.Status;
import com.example.tmp.monopro.entity.User;
import com.example.tmp.monopro.monoexception.StorageFileNotFoundException;
import com.example.tmp.monopro.repo.UserRepository;
import com.example.tmp.monopro.service.StatusServiceImpl;
import com.example.tmp.monopro.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "file/")
public class FileUploadController {
     static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(FileUploadController.class.getName());

    private final StorageService storageService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private StatusServiceImpl statusService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/listfiles")
    public String listUploadedFiles(Model model)  {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/fileupload")
    public RedirectView handleFileUpload(@RequestParam("file") MultipartFile file,
                                         @RequestParam("satname")  String satname,
                                   RedirectAttributes redirectAttributes,
                                         HttpServletRequest httprequest
                                         ) {

        storageService.store(file);

        String msgUploaded=messageSource.getMessage("thetemp.upload.success", null, getLocale());

        redirectAttributes.addFlashAttribute("msg", msgUploaded+" > "+ file.getOriginalFilename() + "!");

        /*redirectAttributes.addFlashAttribute("msg",
                "You successfully uploaded " + file.getOriginalFilename() + "!");*/



        LOGGER.log(Level.SEVERE, "File uploaded {0}.", file.getOriginalFilename());
        String user=httprequest.getSession().getAttribute("usermail")+"";

        Status status=new Status();
        User theUser=userRepository.findByEmail(user);
        status.setUserid(Integer.parseInt(theUser.getUserId()+""));
        status.setFilename(file.getOriginalFilename());
        status.setProcessed(false);
        status.setMailsend(false);
        status.setSatname(satname);
        status.setAzconfig("azconfig");
        status.setProcessdate(LocalDateTime.now());
        status.setUpdatedate(LocalDateTime.now());
        status.setUpdatedate(null);
        status.setAzdescription("azdescription");
        statusService.saveStatus(status);


        RedirectView redirectView = new RedirectView("/main", true);
        redirectView.setUrl("/main");
        return redirectView;
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<String> handleStorageFileNotFound(com.example.tmp.monopro.monoexception.StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

    private Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

}