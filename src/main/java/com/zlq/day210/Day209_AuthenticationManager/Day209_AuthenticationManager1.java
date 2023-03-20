package com.zlq.day210;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day210
 * @ClassName: Day209_AuthenticationManager
 * @description:
 * @author: LiQun
 * @CreateDate:2023/2/9 11:42
 */
/*
你需要设计一个包含验证码的验证系统。每一次验证中，用户会收到一个新的验证码，这个验证码在 currentTime 时刻之后 timeToLive 秒过期。如果验证码被更新了，那么它会在 currentTime （可能与之前的 currentTime 不同）时刻延长 timeToLive 秒。

请你实现 AuthenticationManager 类：

AuthenticationManager(int timeToLive) 构造 AuthenticationManager 并设置 timeToLive 参数。
generate(string tokenId, int currentTime) 给定 tokenId ，在当前时间 currentTime 生成一个新的验证码。
renew(string tokenId, int currentTime) 将给定 tokenId 且 未过期 的验证码在 currentTime 时刻更新。如果给定 tokenId 对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
countUnexpiredTokens(int currentTime) 请返回在给定 currentTime 时刻，未过期 的验证码数目。
如果一个验证码在时刻 t 过期，且另一个操作恰好在时刻 t 发生（renew 或者 countUnexpiredTokens 操作），过期事件 优先于 其他操作。

示例 1：

输入：
["AuthenticationManager", "renew", "generate", "countUnexpiredTokens", "generate", "renew", "renew", "countUnexpiredTokens"]
[[5], ["aaa", 1], ["aaa", 2], [6], ["bbb", 7], ["aaa", 8], ["bbb", 10], [15]]
输出：
[null, null, null, 1, null, null, null, 0]

解释：
AuthenticationManager authenticationManager = new AuthenticationManager(5); // 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
authenticationManager.renew("aaa", 1); // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
authenticationManager.generate("aaa", 2); // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
authenticationManager.countUnexpiredTokens(6); // 时刻 6 时，只有 tokenId 为 "aaa" 的验证码未过期，所以返回 1 。
authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
authenticationManager.renew("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
authenticationManager.renew("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
authenticationManager.countUnexpiredTokens(15); // tokenId 为 "bbb" 的验证码在时刻 15 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。
 */
public class Day209_AuthenticationManager {
    /*
    ["AuthenticationManager","renew","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","generate","generate","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","renew","countUnexpiredTokens","countUnexpiredTokens","renew","countUnexpiredTokens","generate","renew","countUnexpiredTokens","countUnexpiredTokens","renew","renew","renew","generate","renew","generate","countUnexpiredTokens","countUnexpiredTokens","generate","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","renew","generate","generate","generate","countUnexpiredTokens","renew","generate","countUnexpiredTokens","countUnexpiredTokens","generate","generate","generate","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","renew","renew","renew","countUnexpiredTokens","countUnexpiredTokens"]
    [[104],["ox",50],[73],[87],[93],["yyeu",104],["r",131],[167],[172],[191],[206],[232],["r",235],[239],[257],["vi",268],[292],["vi",296],["yu",303],[326],[339],["aimzm",343],["umdzy",346],["qyf",347],["mfne",353],["nn",357],["hz",359],[422],[434],["pel",473],[494],[498],[508],[524],["pt",552],["vbaa",568],["gt",592],["zxdv",611],[618],["fbp",619],["giih",622],[623],[629],["chmi",659],["doohl",671],["svxbv",715],[722],[749],[754],[771],[794],["pel",865],["i",919],["aqa",962],[976],[978]]
88 / 90 个通过的测试用例
输出
[null,null,0,0,0,null,null,2,2,2,2,1,null,1,1,null,1,null,null,2,1,null,null,null,null,null,null,2,2,null,1,1,1,1,null,null,null,null,3,null,null,4,4,null,null,null,4,3,3,2,1,null,null,null,0,0]
     */
    public static void main(String[] args) {
        Day209_AuthenticationManager authenticationManager = new Day209_AuthenticationManager(104);
        authenticationManager.renew("ox", 50);
        System.out.println(authenticationManager.countUnexpiredTokens(73));
        System.out.println(authenticationManager.countUnexpiredTokens(87));
        System.out.println(authenticationManager.countUnexpiredTokens(93));
        authenticationManager.generate("yyeu", 104); // 208 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
        authenticationManager.generate("r", 131); // 235  时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
        System.out.println(authenticationManager.countUnexpiredTokens(167));
        System.out.println(authenticationManager.countUnexpiredTokens(172));
        System.out.println(authenticationManager.countUnexpiredTokens(191));
        System.out.println(authenticationManager.countUnexpiredTokens(206));
        System.out.println(authenticationManager.countUnexpiredTokens(232));
        authenticationManager.renew("r", 235);
        System.out.println(authenticationManager.countUnexpiredTokens(239));
        System.out.println(authenticationManager.countUnexpiredTokens(257));
//
//
//        authenticationManager.countUnexpiredTokens(6);
//        authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
//        authenticationManager.renew("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
//        authenticationManager.renew("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
//        authenticationManager.countUnexpiredTokens(15); // tokenId 为 "bbb" 的验证码在时刻 15 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。
    }

    int timeToLive;
    Map<String, Integer> verificationCodeMap = new HashMap<>();

    public Day209_AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        verificationCodeMap.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        Integer codeTime = verificationCodeMap.get(tokenId);
        if (codeTime == null) return;
        if (codeTime <= currentTime) return;
        else verificationCodeMap.put(tokenId, currentTime + timeToLive);
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (String key : verificationCodeMap.keySet()) {
            if (verificationCodeMap.get(key) > currentTime) count++;
        }
        return count;
    }
}
