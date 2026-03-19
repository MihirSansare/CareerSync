package com.careersync.jobportal.contact.service;

import com.careersync.jobportal.dto.ContactRequestDto;

public interface IContactService {
    boolean saveContactMsg(ContactRequestDto contactRequestDto);
}
