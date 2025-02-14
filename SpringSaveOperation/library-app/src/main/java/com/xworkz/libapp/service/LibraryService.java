package com.xworkz.libapp.service;

import com.xworkz.libapp.dto.LibDto;

public interface LibraryService {
    Boolean validateAndSave(LibDto libDto);
}
