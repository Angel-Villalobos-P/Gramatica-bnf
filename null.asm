.data


.text
li $v0,10
syscall	 

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

