
import java.security.NoSuchAlgorithmException;
import negocio.LoginBO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jacob Vilar
 */
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(LoginBO.getInstance().encriptaSenha("cajobao"));
    }
}
