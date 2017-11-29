/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.IOException;
import java.io.Writer;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Cesar
 */
public class PosicionEncode implements Encoder.TextStream<Jugador>{

    @Override
    public void encode(Jugador object, Writer writer) throws EncodeException, IOException {
        JsonObject json=Json.createObjectBuilder()
                .add("estado", object.getEstado())
                .add("id", object.getId())
                .add("x", object.getX())
                .add("y", object.getX())
                .build();
        /*
        try(JsonWriter jsonWriter =Json.createWriter(writer)){
            jsonWriter.writeObject(json);
        }*/
        JsonWriter jsonWriter =Json.createWriter(writer);
        jsonWriter.writeObject(json);
        
    }

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {        
    }
    
}
