JFLAGS = -g
JC = javac
JVM = java

.SUFFIXES: .java .class

.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		GUI.java

MAIN = GUI

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN)

clean:
		$(RM) *.class
