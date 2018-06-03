package pl.eiti.rso.service;

import com.google.gson.Gson;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.eiti.rso.domain.dto.User;
import pl.eiti.rso.domain.dto.UserDto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service("userDetailsService")
public class UserService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            String url = "http://localhost:9080/user/userPrinicpal?username=" + username;
            URL obj = new URL(url);
            String userPassword = "Kamil" + ":" + "Kamil";
            String encoding = new sun.misc.BASE64Encoder().encode(userPassword.getBytes());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestProperty("Authorization", "Basic " + encoding);
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            StringBuffer response = new StringBuffer();
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);
            in.close();
            Gson gson = new Gson();
            UserDto userdto = gson.fromJson(response.toString(), UserDto.class);
            User user = new User(userdto);
            return (UserDetails) user;
        } catch (Exception ex) {
            throw new UsernameNotFoundException(ex.getMessage());
        }
    }
}