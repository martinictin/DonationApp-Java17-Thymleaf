package com.donationapp.prototype.service;


import com.donationapp.prototype.config.token.ConfirmationToken;

public interface IConfirmationTokenService {
    void saveConfirmationToken(ConfirmationToken token);
    int setConfirmedAt(String token);
}
