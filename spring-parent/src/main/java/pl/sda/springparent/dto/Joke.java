package pl.sda.springparent.dto;

import lombok.Builder;
import lombok.Data;

//{
//        "type": "success",
//        "value": {
//        "id": 298,
//        "joke": "MacGyver immediately tried to make a bomb out of some Q-Tips and Gatorade, but Chuck Norris roundhouse-kicked him in the solar plexus. MacGyver promptly threw up his own heart.",
//        "categories": []
//        }
//        }
@Data
@Builder
public class Joke {
    String type;
    JokeValue value;
}
