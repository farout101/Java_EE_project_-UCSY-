package com.cashnex.security;

//Define a custom exception class for decryption errors
public class DecryptionException extends Exception {
public DecryptionException(String message, Throwable cause) {
   super(message, cause);
}
}