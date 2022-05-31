package com.beta.coffee.betacoffee.endpoints;

import java.util.ArrayList;
import java.util.Optional;

import com.beta.coffee.betacoffee.message.EmailMessage;
import com.beta.coffee.betacoffee.message.Mailer;
import com.beta.coffee.betacoffee.models.Request;
import com.beta.coffee.betacoffee.repository.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class RequestEndpoints {

    private final RequestRepository requestDao;
    private Mailer mailer;

    @Autowired
    public RequestEndpoints(RequestRepository requestDao, Mailer mailer) {
        this.requestDao = requestDao;
        this.mailer = mailer;
    }

    
    @GetMapping(path = "barista/request")
    public ResponseEntity<?> findAll(Pageable pageable){
        return new ResponseEntity<>(requestDao.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "barista/request/name/{name}")
    public ResponseEntity<?> findByNameLike(@PathVariable String name, Pageable pageable){
        return new ResponseEntity<>(requestDao.findByNameLike(name, pageable), HttpStatus.OK);
    }

    @GetMapping(path = "admin/request/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(requestDao.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "user/request")
    public ResponseEntity<?> create(@RequestBody Request request){
        return new ResponseEntity<>(requestDao.save(request), HttpStatus.OK);
    }

    @PutMapping(path = "barista/request")
    public ResponseEntity<?> edit(@RequestBody Request request){
        if(request.getId() > 0){
            Optional<Request> requestId = requestDao.findById(request.getId());
            if(request.getPrepared() & !requestId.get().getPrepared()){
                ArrayList<String> recipients = new ArrayList<>();
                recipients.add("eduardo.aguiarpo@gmail.com");
                sendEmail(recipients, "12345678");
            }
            return new ResponseEntity<>(requestDao.save(request), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    private Integer sendEmail(ArrayList<String> recipients, String body){
        try{
            mailer.submit(new EmailMessage("Suporte <suporte.animais.guaramirim@gmail.com>",
                    recipients, "Senha", "Senha -> " + body));
            return 1;
        }catch (MailException ignored){
            System.out.println(ignored + "erro");
            return 0;
        }
    }
    
}
