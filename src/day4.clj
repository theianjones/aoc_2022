(ns day4
  (:require
    [clojure.set :as set]
    [clojure.string :as string]
    [util]))


(def example (util/parse-input "example4.txt"))
(def input (util/parse-input "input4.txt"))


(->> input
     (map #(string/split % #",|-"))
     (map (fn [[a b c d]]
            (let [a (into #{} (range
                                (Integer/parseInt a)
                                (inc (Integer/parseInt b))))
                  b (into #{} (range
                                (Integer/parseInt c)
                                (inc (Integer/parseInt d))))]
              (or (set/subset? a b)
                  (set/subset? b a)))))
     (filter true?)
     count)


;; => 464



(->> input
     (map #(string/split % #",|-"))
     (map (fn [[a b c d]]
            (let [a (into #{} (range
                                (Integer/parseInt a)
                                (inc (Integer/parseInt b))))
                  b (into #{} (range
                                (Integer/parseInt c)
                                (inc (Integer/parseInt d))))]
              (< 0 (count (set/intersection a b))))))
     (filter true?)
     count)


;; => 770
