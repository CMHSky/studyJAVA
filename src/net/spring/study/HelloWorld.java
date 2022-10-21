package net.spring.study;

public class HelloWorld {
  private String message;

  public void setMessage(String message) {
    this.message = message;
  }

  public void getMessage() {
    System.out.println("message: " + message);
  }

  public void init() {
    System.out.println("Bean 正在初始化");
  }

  public void destroy() {
    System.out.println("Bean 将要被销毁");
  }
}
