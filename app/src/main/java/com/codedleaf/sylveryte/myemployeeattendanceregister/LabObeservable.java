package com.codedleaf.sylveryte.myemployeeattendanceregister;

/**
 * Created by sylveryte on 14/6/16.
 *
 * Copyright (C) 2016 sylveryte@codedleaf <codedlaf@gmail.com>
 *
 * This file is part of My Employee Attendance Register.
 *
 */
public interface LabObeservable {

    void addListener(LabObserver labObserver);
    void alertAllObservers();
}
