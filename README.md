# Demo for spring properties with names placeholders instead of numbered

## Blog
https://viktorreinok.medium.com/how-to-improve-your-properties-game-in-your-i18-spring-application-with-more-meaningful-value-14b9d3f34159

## Motivation

Old
```
transation.1.en=I want to {0} my {1} 
transation.1.de=Ich will mein {1} {0}
```

New
```
transation.1.en=I want to #{'$'}{action} my {program_name} 
transation.1.de=Ich will mein #{'$'}{program_name} {action}
```


Refs:
- https://stackoverflow.com/questions/48827440/skip-spring-placeholder-substitution/48827780#48827780
- 