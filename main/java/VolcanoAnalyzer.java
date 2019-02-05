import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class VolcanoAnalyzer {
    public List<Volcano> getVolcanoes() {
        return volcanoes;
    }

    public void setVolcanoes(List<Volcano> volcanoes) {
        this.volcanoes = volcanoes;
    }

    private List<Volcano> volcanoes;

    public void loadVolcanos(Optional<String> pathOpt) throws IOException, URISyntaxException {
        try{
            String path = pathOpt.orElse("volcano.json");
            URL url = this.getClass().getClassLoader().getResource(path);
            String jsonString = new String(Files.readAllBytes(Paths.get(url.toURI())));
            ObjectMapper objectMapper = new ObjectMapper();
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            this.volcanoes = objectMapper.readValue(jsonString, typeFactory.constructCollectionType(List.class, Volcano.class));
        } catch(Exception e){
            throw(e);
        }
    }

    public List<Volcano> returnVolcanoesFrom(Integer lowerYear, Integer upperYear) {
             List<Volcano> volcano = volcanoes.stream()
                     .filter(volcanoes -> volcanoes.getYear() >= lowerYear)
                     .filter(volcanoes -> volcanoes.getYear()<= upperYear)
                     .collect(Collectors.toList());

             return volcano;

    }

    public String[] returnVolcanoNamesWithVei(int Vei){

        String[] volcano = volcanoes.stream()
                .filter(volcanoes -> volcanoes.getVEI() >= Vei)
                .map(Volcano::getName).toArray(String[]::new);

            return volcano;

    }

    public String[] returnHighestNumberDeaths(String deaths){
        String[] volcano = volcanoes.stream()
                .filter(volcanoes -> volcanoes.setDEATHS() )
    }

}
