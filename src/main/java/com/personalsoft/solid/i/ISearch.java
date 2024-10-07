package com.personalsoft.solid.i;

import java.util.List;

public interface ISearch {

    List<String> getStringsWithId(int id);
    List<String> findWithNullId();
}
