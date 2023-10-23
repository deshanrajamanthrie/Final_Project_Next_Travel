package lk.ijse.gdse.user.controller;

import lk.ijse.gdse.user.dto.BookingDTO;
import lk.ijse.gdse.user.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/booking")
@CrossOrigin
public class BookingController {

    @Autowired
    BookingService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookingDTO postBooking(@RequestBody BookingDTO dto){
        return service.saveBooking(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookingDTO putBooking(@RequestBody BookingDTO dto){
        return service.updateBooking(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookingDTO> getAllBooking(){
        List<BookingDTO> allBooking = service.getAllBooking();
        return allBooking;
    }

    @GetMapping(path = "search",params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingDTO searchBooking(@RequestParam("id") Long myId){
        return service.searchBook(myId);
    }

    @DeleteMapping(params = {"id"})
    public void deleteBooking(@RequestParam("id") Long myId){
        service.deleteBooking(myId);

    }

}
