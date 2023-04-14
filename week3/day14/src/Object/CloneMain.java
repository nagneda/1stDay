package Object;


public class CloneMain {

    /* clone()
         객체를 복사해서 새로운 인스턴ㅅ(객체 생성)
         얕은 복사 깊은 복사로 나눠진다.

         일반변수일 경우에는 값 그대로 복사 가능하다.
         참조변수일떄는 직접 값을 복사 하는 것이 아니라 주소를 복사하는 것이기 떄문에 문제가 발생할 수 있다.
    */
    public static void main(String[] args) {
        User user1 = new User("love","love");

        try {
            User copy = (User)user1.clone(); // clone의 반환타입은 object이기 떄문에 형변환을 해줘야 한다.
            System.out.println(copy.hashCode()); // 복사된 인스턴스와 기존의 인스턴스 해쉬코드가 다름으로써
            System.out.println(user1.hashCode()); // 서로 독립된 객체임을 알 수 있음.

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    // 오버라이딩은 꼭 메서드의 내용을 재정의 할때만 사용하는 것은 아니다
    // 다음과 같이 접근제어자를 변경할떄도 사용을 한다. 메서드명과 반환타입 매개변수 등은 절대 바꿔서는 안되지만 접근제어자는 가능하기 떄문에
    // protected -> public으로 바꿔주고 USer 클래스의 객체들은 누구나 접근해서 복사할 수 있도록 설정한다.

    // clone()메서드를 접근 제어자가 바뀌면 무분별하게 객체들을 복사하는 경우가 생길 수 있다
    // 그래서 특정 인터페이스를 구현해야만 사용할 수 있다.

    // clone() 메서드를 사용하기 위해서는 다음을 유의하자

    // 접근제어자 변경하기, 인터페이스 cloneable구현하기, 그리고 예외발생하니 예외처리도 해줘야한다.


    //? 근데 protected면 조상에서 접근이 되고 object상속돼있으니 사용가능한 거 아닌가?

    // -> 아니다. 내가 지금 실행시키려는 클래스는 Main이고 User클래스에 clone()메서드를 오버라이딩한 상황이다
    // 유저와 메인 클래스는 둘다 오브젝트로 클래스에게 상속받는다. 이 때 메인클래스에서 생성한 유저클래스의 참조변수로
    // 제어자가 protected인 메서드에 접근할 수 있을까? 접근하지 못한다. 거기서 오버라이딩 했기 때문에 바깥의 클래스에서 참조변수로 접근못한다.
    // private쓸떄는 오직 본인의 클래스 내여야만 한다는 것과 같은 개념이다 따라서 아래와 같이 작성은 가능하다.
    //CloneMain m = new CloneMain();
    //        m.clone(); // 얘는 문제없이 작성가능하다. 물론 예외처리는 해줘야하지만.
    // 이를 헤결하기 위해서는 실행시키려는 메서드가 다른 클래스를 상속받고 그 클래스에 오버라이딩 된 clone()을 사용하면 되지만
    // 번거롭기 떄문에 그냥 현재 메인 클래스에 오버라이딩 시키고 접근제어자만 public으로 바꾼것. 그러면서 다형성 떄문에 (User)로 캐스팅을 해준것이다.

}
