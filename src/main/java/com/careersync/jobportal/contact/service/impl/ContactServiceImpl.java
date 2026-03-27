package com.careersync.jobportal.contact.service.impl;

import com.careersync.jobportal.contact.service.IContactService;
import com.careersync.jobportal.dto.ContactRequestDto;
import com.careersync.jobportal.entity.Contact;
import com.careersync.jobportal.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {

    private final ContactRepository contactRepository;

    @Override
    public boolean saveContactMsg(ContactRequestDto contactRequestDto) {
        boolean result = false;
        Contact contact = contactRepository.save(transformToEntity(contactRequestDto));
        if(contact.getId() != null){
            result = true;
        }
        return result;
    }

    private Contact transformToEntity(ContactRequestDto contactRequestDto) {
       Contact contact = new Contact();
       BeanUtils.copyProperties(contactRequestDto, contact);
       contact.setStatus("NEW");
       return contact;
    }
}
