package assignment01_file_operation;

import CourseUtil.Util;

public class AssignmentFileOperation {
    public static void main(String[] args) {

        FileService.read("file01.txt").subscribe(Util.onNext(), Util.onError(), Util.onComplete());

//        FileService.write("file03.txt","this is file 3").subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.delete("file03.txt").subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
