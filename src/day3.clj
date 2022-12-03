(ns day3
  (:require
    [clojure.set :as set]
    [util]))


(->> "input3.txt"
     (util/parse-input)
     (map #(split-at (/ (count %) 2) (into [] %)))
     (map (fn [cols] (map #(into #{} %) cols)))
     (mapcat (fn [[s1 s2]] (into [] (set/intersection s1 s2))))
     (map #(if (Character/isUpperCase %)
             (- (int %) 38)
             (- (int %) 96)))
     (apply +))


;; => 7581

(->> "input3.txt"
     util/parse-input
     (map #(->> %
                char-array
                seq
                (into #{})))
     (partition 3)
     (mapcat #(->> %
                   (apply set/intersection)
                   (into [])))
     (map #(if (Character/isUpperCase %)
             (- (int %) 38)
             (- (int %) 96)))
     (apply +))


;; => 2525
