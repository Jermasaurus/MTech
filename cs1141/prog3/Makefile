.SUFFIXES: .c .o
CC = gcc
EXEC = wrap
CCFLAGS = -ansi -pedantic
OBJS = wrap.o func.o

${EXEC}: ${OBJS}
	${CC} ${CCFLAGS} -o ${EXEC} ${OBJS}

.c.o:
	${CC} ${CCFLAGS} -c $<

run: ${EXEC}
	./${EXEC}
    
clean:
	rm -f ${EXEC} ${OBJS}

wrap.o: wrap.c func.c func.h
func.o: func.c func.h
