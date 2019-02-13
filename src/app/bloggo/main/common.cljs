(ns bloggo.main.common)

(defn dom-event->value [event]
  (-> event
      .-target
      .-value))
