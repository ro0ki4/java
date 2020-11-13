package pan.xu;

public class CPU_GPU {
    public static void main(String[]args){
        product computer1=new pc();
        computer1.create_cpu();
        computer1.create_ram();
        System.out.println(computer1);
        product computer2=new mac();
        computer2.create_cpu();
        computer2.create_ram();
        System.out.println(computer2);

    }
}

interface product{
    public abstract CPU create_cpu();
    public abstract RAM create_ram();
}

class pc extends myshow implements product{
    @Override
    public CPU create_cpu() {
        this.cpu_name=new cpu_pc().getClass().getName();
        return new cpu_pc();
    }

    @Override
    public RAM create_ram() {
        this.ram_name=new ram_pc().getClass().getName();
        return new ram_pc();
    }
}

class mac extends myshow implements product{

    @Override
    public CPU create_cpu() {
        this.cpu_name=new cpu_mac().getClass().getName();
        return new cpu_mac();
    }

    @Override
    public RAM create_ram() {
        this.ram_name=new ram_mac().getClass().getName();
        return new ram_mac();
    }
}

interface CPU{
    public abstract String show();
}

interface RAM{
    public abstract String show();
}

class cpu_pc implements CPU{
    @Override
    public String show(){
        return "pc_cpu";
    }
}

class cpu_mac  implements CPU{
    @Override
    public String show(){
        return "mc_cpu";
    }
}

class ram_pc  implements RAM{

    @Override
    public String show() {
        return "pc_ram";
    }
}

class ram_mac implements RAM{
    @Override
    public String show(){
        return "mac_ram";
    }
}

class myshow{
    String cpu_name=null;
    String ram_name=null;
    public String toString(){
        return this.getClass().getName()+"\n"+cpu_name+"\n"+ram_name+"\n************************";
    }
}