package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    public static LottoTickets buy(PurchaseAmount purchaseAmount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < purchaseAmount.getNumberOfAvailableBuyLotto(); i++) {
            tickets.add(generateNewLotto());
        }
        return new LottoTickets(tickets);
    }

    private static Lotto generateNewLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream().sorted()
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
}
