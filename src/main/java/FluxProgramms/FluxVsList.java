package FluxProgramms;

import CourseUtil.Util;
import FluxProgramms.helper.NameGenerator;

import java.util.List;

public class FluxVsList {
    public static void main(String[] args) {
//        List<String> names = NameGenerator.getNames(5);
//        System.out.println(names);

        NameGenerator.getNameFlux(5).subscribe(Util.onNext()); //not waiting for 5 seconds to emit result, the moment it have the item it emits
    }
}
