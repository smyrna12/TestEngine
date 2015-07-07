package smyrna.factory;

import smyrna.base.ActivityType;

/**
 * Created by Erdem.Akdogan on 6/4/15
 */
public class ActivityFactoryProducer {
    public static ActivityFactory getFactory(ActivityType choice) {
        switch (choice) {
            case CC:
                return new CheckoutCompletedFactory();
            case IS:
                return new IdentitySignupFactory();
            case VR:
                return new VisitResourceFactory();
            case VC:
                return new VisitCategoryFactory();
            case VP:
                return new VisitProductFactory();
            case CS:
                return new CheckoutStartFactory();
            case NS:
                return new NewsletterSubscribeFactory();
            default:
                break;
        }

        return null;
    }
}
