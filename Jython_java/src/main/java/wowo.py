#encoding=UTF-8

from jython import SayHello
execpy = SayHello()

#################################################
#将python属性传入后续调用的java实例
execpy.setUserName(userName)

def say():
    execpy.say(5)
    return

if (__name__=="__main__"):
    say()
    # plt.plot([1,2,3],[2,3,4],"b.")
    # plt.show()
    # plt.close()

