package com.esprit.khalloufhamzaexamenbalnco.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
@Slf4j
public class AspectExamen {
    @Before("execution(* com.esprit.khalloufhamzaexamenbalnco.service.*.get*(..))")
    public void avant(JoinPoint JoinPoint) {
        log.info("In the method "+ JoinPoint.getSignature().getName() +" at " + new Date());
    }
}


//        . Join point : L'endroit où l'on veut qu’un aspect s'applique; comme l’appel
//        d'une méthode ou le lancement d’une exception
//
//        • Pointcut : Une expression, qui permet de sélectionner plusieurs Join points.
//        Par exemple, «toutes les méthodes public dans un package précis».
//
//        • Advice : Le code que l'on veut rajouter. On peut ajouter ce code avant,
//        après, autour de la méthode...
//
//        • Aspect : Une classe qui encapsule une fonctionnalité transverse et elle est
//        composée d'un ou de plusieurs Pointcut et Advice. La classe est annotée @Aspect.
//
//• Weaving (tissage) : action d'insertion des aspects (Fait par Spring AOP).



//
//        • Before advice : s’exécute avant le Join point. S’il lance une Exception, le Join
//        point ne sera pas appelé
//
//        • After returning advice : s’exécute après le Join point, si celui-ci s’est bien exécuté
//        (s’il n’y a pas d'Exception)
//
//        • After throwing advice : s’exécute si une Exception a été lancée pendant
//        l’exécution du Join point
//
//        • After advice : s’exécute après le Join point, qu’il y ait eu une Exception ou non
//
//        • Around advice : s’exécute autour du Join point. C’est l’advice le plus puissant.