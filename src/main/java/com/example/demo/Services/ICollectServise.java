package com.example.demo.Services;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Collect;
import com.example.demo.Bean.Response;

public interface ICollectServise {
    Response selfCollect(int userid);

    AResponse addCollect(Collect collect);

    AResponse deleteCollect(int id);
}
