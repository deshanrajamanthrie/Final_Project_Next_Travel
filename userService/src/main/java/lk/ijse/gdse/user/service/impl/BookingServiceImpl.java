package lk.ijse.gdse.user.service.impl;

import lk.ijse.gdse.user.dto.BookingDTO;
import lk.ijse.gdse.user.entity.Booking;
import lk.ijse.gdse.user.repo.BookingRepo;
import lk.ijse.gdse.user.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepo repo;
    @Autowired
    ModelMapper mapper;

    public BookingDTO saveBooking(BookingDTO dto){
        if(repo.existsById(dto.getBookingId())){
            throw new RuntimeException("Booking Has Been Already Added!");
        }else{
            repo.save(mapper.map(dto, Booking.class));
        }
        return dto;
    }

    public  BookingDTO updateBooking(BookingDTO dto){
        if(!repo.existsById(dto.getBookingId())){
            throw new RuntimeException("Booking NotFound!");
        }else{
            repo.save(mapper.map(dto,Booking .class));
        }
        return dto;
    }

    public List<BookingDTO> getAllBooking(){
        return mapper.map(repo.findAll(),new TypeToken<List<BookingDTO>>(){}.getType());
    }

    public BookingDTO searchBook(Long  id){
        if(!repo.existsById(id)){
            throw new RuntimeException("Booking NotFound!");
        }else{
            return mapper.map(repo.findById(id).get(),BookingDTO.class);
        }
    }

    public void deleteBooking(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("Booking NotFound!");
        }else {
            repo.delete(repo.findById(id).get());
        }
    }
}
