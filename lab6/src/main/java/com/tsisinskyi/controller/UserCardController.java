package com.tsisinskyi.controller;

import com.tsisinskyi.DTO.UserCardDTO;
import com.tsisinskyi.mapper.UserCardMapper;
import com.tsisinskyi.model.UserCard;
import com.tsisinskyi.service.UserCardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/user_card")
public class UserCardController {
    private final UserCardService userCardService;

    @GetMapping
    public List<UserCardDTO> getAllUserCard() {
        return userCardService.getAllUserCard().stream()
                .map(UserCardMapper::mapUserCardToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCardDTO> getUserCardById(@PathVariable("id") Integer id) {
        UserCard userCard = userCardService.getUserCardById(id);
        if (userCard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                UserCardMapper.mapUserCardToDTO(userCard), HttpStatus.OK);
    }

    @PostMapping
    public UserCardDTO createUserCard(@RequestBody UserCardDTO userCardDTO) {
        return UserCardMapper.mapUserCardToDTO(userCardService.createUserCard(userCardDTO));
    }

    @PutMapping
    public ResponseEntity<UserCardDTO> updateUserCard(@RequestBody UserCardDTO userCardDTO) {
        UserCard userCard = userCardService.getUserCardById(userCardDTO.getId());
        if (userCard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                UserCardMapper.mapUserCardToDTO(userCardService.updateUserCard(userCardDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserCardDTO> deleteUserCard(@PathVariable("id") Integer id) {
        UserCard userCard = userCardService.getUserCardById(id);
        if (userCard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                UserCardMapper.mapUserCardToDTO(userCardService.deleteUserCardById(id)), HttpStatus.OK
        );
    }

}