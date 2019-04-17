package limeapp.model.dao;

/**
 * Created by zeecitizen on 4/17/2019.
 */

public class RepositoryException extends Exception {

  public RepositoryException(String message) {
    super(message);
  }

  public RepositoryException(String message, Throwable cause) {
    super(message, cause);
  }
}

