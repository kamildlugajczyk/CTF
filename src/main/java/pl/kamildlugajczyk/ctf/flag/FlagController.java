package pl.kamildlugajczyk.ctf.flag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class FlagController {

    @Autowired
    FlagService flagService;

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public boolean validateFlag(@RequestBody Flag flag) {
        return flagService.validateFlag(flag);
    }

}
