package me.kktrkkt;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

// META-INF/services 에 자동으로 Processor를 추가해준다
@AutoService(Processor.class)
public class MagicProcessor extends AbstractProcessor {

    // 프로세서가 처리할 애노테이션 목록을 설정한다
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(Magic.class.getName());
    }

    // 지원하는 소스 버전을 설정합니다
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    //TypeElement는 소스 코드의 구성요소로, package, class, method 등등이 있다.
    // true룰 리턴하면 더 이상 애노테이션을 다른 프로세서에서 처리하지 않는다
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Magic.class);
        for(Element element : elements){
            Name simpleName = element.getSimpleName();
            if(element.getKind() != ElementKind.INTERFACE){
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Magic can not be used on " + simpleName);
             } else {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Proccessing " + simpleName);
            }
        }
        return true;
    }
}
