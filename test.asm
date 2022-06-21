.data
temp: .word 0
y: .float 0.0
str: .asciiz ""


.text
main: 

li $v0,10
syscall	 

.end main


printStr:
    li   $v0, 4
    syscall
    jr $ra
.end printStr

printInt:
    li   $v0, 1
    syscall
    jr $ra
.end printInt

printFloat:
    li   $v0, 2
    syscall
    jr $ra
.end printFloat

readInt:
    li   $v0, 5
    syscall
    jr $ra
.end readInt

readFloat:
    li   $v0, 6
    syscall
    jr $ra
.end readFloat

