package me.kktrkkt;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.util.Set;

public class MagicProccessor extends AbstractProcessor {

    // 프로세서가 처리할 애노테이션 목록을 설정한다
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(Magic.class.getName());
    }

    //TypeElement는 소스 코드의 구성요소로, package, class, method 등등이 있다.
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }
}
