# Demo for spring properties with names placeholders instead of numbered

## Motivation

Old
```
transation.1.en=I want to {0} my {1} 
transation.1.de=Ich will mein {1} {0}
```

New
```
transation.1.en=I want to {action} my {program_name} 
transation.1.de=Ich will mein {program_name} {action}
```

...