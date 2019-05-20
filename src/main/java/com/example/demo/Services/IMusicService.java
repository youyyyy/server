package com.example.demo.Services;

import com.example.demo.Bean.AResponse;
import com.example.demo.Bean.Response;

public interface IMusicService {
    AResponse selectByFobjectid(int fobjectid);

    Response allMusic();

    AResponse deleteMusaic(int id);
}
