/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.IOException;
import java.io.Reader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Cesar
 */
public class PosicionDecode implements Decoder.TextStream<Jugador>{

    @Override
    public Jugador decode(Reader reader) throws DecodeException, IOException {
        Jugador posicion=new Jugador();
        /*try(JsonReader jsonReader=Json.createReader(reader)){
            JsonObject json=jsonReader.readObject();
            posicion.setId(json.getString("id"));
            posicion.setX(json.getString("x"));
            posicion.setY(json.getString("y"));
        }*/
        JsonReader jsonReader=Json.createReader(reader);
        JsonObject json=jsonReader.readObject();
        posicion.setEstado(json.getString("estado"));
        posicion.setId(json.getString("id"));
        posicion.setX(json.getString("x"));
        posicion.setY(json.getString("y"));
        return posicion;
    }

    @Override
    public void init(EndpointConfig config) {
        
    }

    @Override
    public void destroy() {
        
    }
    
}
