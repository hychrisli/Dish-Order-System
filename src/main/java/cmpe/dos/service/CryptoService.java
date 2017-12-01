package cmpe.dos.service;

import java.security.Key;

import cmpe.dos.exception.AppException;

public interface CryptoService {
    
    public Key getKeyBySecret() throws AppException;
    
    public byte[] encrypt(String value) throws AppException;
    
    public String decrypt(byte[] data) throws AppException;
       
}
