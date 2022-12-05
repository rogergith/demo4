package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.google.gson.Gson;


@Controller
public class ControllerPage {
	
	@RequestMapping(value = "/holaPage")
	public ModelAndView index(Model model) {
		
		HashMap<String, Object> attributeValue = new HashMap<String, Object>();
		attributeValue.put("nombre", "Roger");
		attributeValue.put("apellido", "Araque");
		
		//Gso
		
		
		/*
		{
		    "website":"ambrose.net",
		    "id":10,
		    "email":"Rey.Padberg@karina.biz",
		    "username":"Moriah.Stanton",
		    "phone":"024-648-3804",
		    "name":"Clementina DuBuque",
		    "address":{
		       "zipcode":"31428-2261",
		       "geo":{
		          "lng":"57.2232",
		          "lat":"-38.2386"
		       },
		       "suite":"Suite 198",
		       "city":"Lebsackbury",
		       "street":"Kattie Turnpike"
		    },
		    "company":{
		       "bs":"target end-to-end models",
		       "catchPhrase":"Centralized empowering task-force",
		       "name":"Hoeger LLC"
		    },
		 }
		*/
		
		ArrayList<Root> roots = new ArrayList<>();
		
		URL url = null;
		HttpURLConnection http = null;
		Root user = null;
		JSONArray jsonObject = null;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/users");
			http = (HttpURLConnection)url.openConnection();
			
			InputStreamReader inputStreamReader = new InputStreamReader(http.getInputStream());
			
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = bufferedReader.readLine()) != null) {
				response.append(inputLine);
			}
			
			jsonObject = new JSONArray(response.toString());
						
			for (int index = 0; index < jsonObject.length(); index++) {
				JSONObject object = new JSONObject(jsonObject.getJSONObject(index).toString());
				
				Gson gson = new Gson();  
				user = gson.fromJson(object.toString(), Root.class); 
		
				roots.add(user);
				
			}
			
			
			bufferedReader.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
		ModelAndView modelAndView = new ModelAndView("hola");
		
		modelAndView.addObject("users", roots);
		
		modelAndView.addObject("jsonObject", jsonObject);
		
		return modelAndView;
	}



class Address{
    public String zipcode;
    public Geo geo;
    public String suite;
    public String city;
    public String street;
    
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Geo getGeo() {
		return geo;
	}
	public void setGeo(Geo geo) {
		this.geo = geo;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "Address [\n\tzipcode = " + zipcode + ",\n       geo = " + geo + ",\n       suite = " + suite
				+ ",\n       city = " + city + ",\n       street = " + street + "\n]";
	}
	
	
    
}

class Company{
    public String bs;
    public String catchPhrase;
    public String name;
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	public String getCatchPhrase() {
		return catchPhrase;
	}
	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}

class Geo{
    public String lng;
    public String lat;
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "Geo [\n\tlng = " + lng + ",\n       lat = " + lat + "\n]";
	}
	
	
    
}

class Root{
    public String website;
    public int id;
    public String email;
    public String username;
    public String phone;
    public String name;
    public Address address;
    public Company company;
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Root [\n\twebsite = " + website + ",\n       id = " + id + ",\n       email = " + email
				+ ",\n       username = " + username + ",\n       phone = " + phone + ",\n       name = " + name
				+ ",\n       address = " + address + ",\n       company = " + company + "\n]";
	}
	
	
    
}

class Pago {
	private int monto;
	private Transaccion transaccion;
	public Pago(int monto) {
		this.monto = monto;
	}
	public Pago(int monto, Transaccion transaccion) {
		super();
		this.monto = monto;
		this.transaccion = transaccion;
	}
	public Transaccion getTransaccion() {
		return transaccion;
	}
	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	@Override
	public String toString() {
		return "Pago [\n\tmonto = " + monto + ",\n       transaccion = " + transaccion + "\n]";
	}
	
	
	
}

class Transaccion {
	private int id;
	private int monto;
	private int status;
	
	public Transaccion(int id, int monto, int status) {
		super();
		this.id = id;
		this.monto = monto;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Transaccion [\n\tid = " + id + ",\n       monto = " + monto + ",\n       status = " + status + "\n]";
	}
	
	
	
}
	
}
