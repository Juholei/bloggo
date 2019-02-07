(ns bloggo.frontend.common)

(defn dom-event->value [event]
  (-> event
      .-target
      .-value))
