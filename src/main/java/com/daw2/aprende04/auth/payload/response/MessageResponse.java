package com.daw2.aprende04.auth.payload.response;

import lombok.Data;

@Data
public class MessageResponse {
  private String message;

  public MessageResponse(String message) {
    this.message = message;
  }

}
