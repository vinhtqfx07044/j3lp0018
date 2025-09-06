package vn.edu.funix.j3lp0018.service;

import jakarta.servlet.http.HttpServletRequest;

public interface SessionService {
    void handleNewSession(HttpServletRequest request);
}