# Summary
To minimize the impact of malicious attacks against smart infrastructures, attacks need to be detected with minimal delay. To achieve this objective, infrastructure operators may deploy intrusion detection systems (IDS), such as anomaly-based detectors, capable of detecting malicious behavior promptly and accurately. These IDS need to be configured properly, as oversensitive IDS could detect attacks very early but at the cost of a high number of false alarms. Similarly, IDS with low sensitivity could reduce the number of false alarms, but they would increase the detection delay. Striking the right balance between the detection time and the rate of false positives in such IDS is a challenging task, especially in the dynamical environments, where the damage caused by a successful attack is time-varying.

Using a game-theoretic setup, we study the problem of finding optimal detection thresholds for anomaly-based detection in dynamical systems. To obtain optimal detection thresholds, we formulate a two-player Stackelberg game between a defender and an adversary. We assume that the adversary attacks the system, choosing the time and type of its attack to maximize the inflicted damage. On the other hand, the defender selects  optimal detection thresholds to minimize both damage from best-response attacks and the cost of false alarms. 

This project implements a dynamic programming-based algorithm that computes optimal time-dependent thresholds. As a case study, we consider detecting contamination attacks in a real water network.

## Related Publications:
Amin Ghafouri, Waseem Abbas, Aron Laszka, Yevgeniy Vorobeychik, and Xenofon Koutsoukos, “Optimal Thresholds for Anomaly-Based Intrusion Detection in Dynamical Environments.” *2016 Conference on Decision and Game Theory for Security (GameSec 2016)*, New York, NY, Nov. 2 – 4, 2016.

Amin Ghafouri, Aron Laszka, Waseem Abbas, Yevgeniy Vorobeychik, and Xenofon Koutsoukos, “A Game-Theoretic Approach for Selecting Optimal Thresholds for Attack Detection in Dynamical Environments.” *Submitted to the IEEE Transactions on Systems, Man, and Cybernetics: Systems*.
