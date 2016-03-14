package com.russomi.service;

import com.russomi.domain.LookupObject;


public interface LookupRepository {

    LookupObject getByName(String name);
}
