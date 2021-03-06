package com.codedleaf.sylveryte.myemployeeattendanceregister.Picknation;

import com.codedleaf.sylveryte.myemployeeattendanceregister.GeneralObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by sylveryte on 20/7/16.
 *
 * Copyright (C) 2016 sylveryte@codedleaf <codedleaf@gmail.com>
 *
 * This file is part of My Employee Attendance Register.
 *
 */
public class PickCache {
    private static PickCache sPickCache;

    private HashMap<String,List<UUID>> mForPickMap;
    private HashMap<String,List<? extends Pickable>> mForShowMap;
    private HashMap<String,GeneralObserver> ObserverMap;

    private Pickable mPickable;

    private PickCache()
    {
        mForPickMap =new HashMap<>(3);
        mForShowMap =new HashMap<>(3);
        ObserverMap=new HashMap<>(3);
    }

    public Pickable getPickable() {
        return mPickable;
    }

    public void setPickable(Pickable pickable) {
        mPickable = pickable;
    }

    public void storePicked(String id, List<UUID> list)
    {
        mForPickMap.put(id,list);
    }

    public void storePickables(String id,List<? extends Pickable> pickables)
    {
        mForShowMap.put(id,pickables);
    }
    public List<? extends Pickable> getPickables(String id)
    {
        return mForShowMap.get(id);
    }

    public void storeRemoved(String id, List<UUID> list)
    {
        storePicked(id+"r",list);
    }

    public List<UUID> getPicked(String id)
    {
        List<UUID> toReturn=new ArrayList<>(0);
        if (mForPickMap.containsKey(id))
        {
            toReturn= mForPickMap.get(id);
        }

        return toReturn;
    }

    public List<UUID> getRemoved(String id)
    {
        return getPicked(id+"r");
    }


    public void addObserver(String id,GeneralObserver observer)
    {
        ObserverMap.put(id,observer);
    }
    public GeneralObserver getObserver(String id)
    {
        return ObserverMap.get(id);
    }




    public static PickCache getInstance()
    {
        if (sPickCache==null)
            sPickCache=new PickCache();
        return sPickCache;
    }
}
