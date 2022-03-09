package hellojpa;

import hellojpa.shop.domain.Team;
import hellojpa.shop.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //회원 등록
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//
//            em.persist(member);

            //회원 조회
//            Member findMember = em.find(Member.class, 1L);

            //회원 수정
//            findMember.setName("HelloJPA");

            //JPQL
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5) //페이징
//                    .setMaxResults(10) //페이징
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            //영속성 컨텍스트
            //비영속
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("HelloJPA");

            //영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

//            Member findMember1 = em.find(Member.class, 100L);
//            Member findMember2 = em.find(Member.class, 100L);

            //플러시
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush();

            //준영속 상태
//            Member member = em.find(Member.class, 200L);
//            member.setName("AAAAA");
//
////            em.detach(member);
//            em.clear();

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            User user = new User();
            user.setName("user1");
            user.setTeam(team);
            em.persist(user);

            em.flush();
            em.clear();

            User findUser = em.find(User.class, user.getId());

            Team findTeam = findUser.getTeam();
            System.out.println("findTeam = " + findTeam.getName());

            //객체 지향적인 방법X
//            User findUser = em.find(User.class, user.getName());
//
//            Long findTeamId = findUser.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
