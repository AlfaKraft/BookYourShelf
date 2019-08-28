package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.dao.BorrowDao;
import com.tieto.bookyourshelf.library.dao.entityes.BorrowEnt;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import com.tieto.bookyourshelf.library.service.dto.BorrowDto;
import com.tieto.bookyourshelf.library.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    public MailSender mailSender;
    private SimpleMailMessage templateMessage;

    @Autowired
    BorrowDao borrowDao;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    //@Scheduled(fixedDelay=100000)
    //@Scheduled(cron="0 0 0 ? *")
    //@Scheduled(fixedDelay=1000)
    //@Scheduled(cron="0 0 10 ? * MON-FRI")
    @Scheduled(cron="0 12 14 ? * MON-FRI")
    public void sendNotification() {
        Date date = new Date();;

        List<BorrowEnt> borrowsWithDueDatesExpired = borrowDao.findBorrowEntByDateToBringBeforeAndDateBroughtIsNull(date);
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);

        for (int i = 0; i < borrowsWithDueDatesExpired.size(); i++) {

            UserDto user = userService.getUserById(borrowsWithDueDatesExpired.get(i).getIdUser());
            BookDto book = bookService.getBookById(borrowsWithDueDatesExpired.get(i).getIdBook());
            msg.setTo(user.getEmail());
            msg.setText(
                    "Dear user," +
                            "\n\n" +
                            "please return " +
                            book.getTitle()+"!"+
                            "\n\n" +
                            "Your Library " );
            try{
                this.mailSender.send(msg);
            }
            catch(MailException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
